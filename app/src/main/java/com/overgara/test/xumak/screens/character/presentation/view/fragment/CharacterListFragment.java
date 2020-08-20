package com.overgara.test.xumak.screens.character.presentation.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.overgara.test.xumak.R;
import com.overgara.test.xumak.base.BaseFragment;
import com.overgara.test.xumak.presentation.viewmodel.state.StateData;
import com.overgara.test.xumak.screens.character.presentation.model.Character;
import com.overgara.test.xumak.screens.character.presentation.view.adapter.CharacterAdapter;
import com.overgara.test.xumak.screens.character.presentation.view.listener.CharacterClickListener;
import com.overgara.test.xumak.screens.character.presentation.viewmodel.CharacterViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

/**
 * Created By oscar.vergara on 14/08/2020
 */
@AndroidEntryPoint
public class CharacterListFragment extends BaseFragment implements CharacterClickListener {
    private List<Character> characters = new ArrayList<>();
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private int fetch = 10;
    private RecyclerView.OnScrollListener scrollListener;
    private ImageView toTop;
    private ImageView toBottom;

    private CharacterViewModel characterViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_character_list,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        characterViewModel = new ViewModelProvider(requireActivity()).get(CharacterViewModel.class);
        observeCharactersList();

        if(characterViewModel.getListObs().getValue() != null
                && characterViewModel.getListObs().getValue().getData() != null) {
            characters = characterViewModel.getListObs().getValue().getData();
        }

        if(characters.size() == 0){
            getCharacters();
        }
    }

    private void getCharacters(){
        characterViewModel.getCharacters(fetch,characters.size());
    }

    private void initViews() {
        recyclerView = requireActivity().findViewById(R.id.characters_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new CharacterAdapter(this));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(setupScrollListener());
        swipeRefreshLayout = requireActivity().findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(this::getCharacters);

        toTop = requireActivity().findViewById(R.id.characters_toTop);
        toBottom = requireActivity().findViewById(R.id.characters_toBottom);

        toTop.setOnClickListener(view->{
            toBottom.setVisibility(View.VISIBLE);
            toTop.setVisibility(View.INVISIBLE);
            recyclerView.removeOnScrollListener(scrollListener);
            recyclerView.scrollToPosition(0);
            recyclerView.addOnScrollListener(setupScrollListener());
        });

        toBottom.setOnClickListener(view->{
            toTop.setVisibility(View.VISIBLE);
            toBottom.setVisibility(View.INVISIBLE);
            recyclerView.scrollToPosition(characters.size()-1);
        });
    }

    private void observeCharactersList(){
        characterViewModel.getListObs().observe(getViewLifecycleOwner(), this::charactersObserver);
    }

    private void charactersObserver(StateData<List<Character>> response) {
        switch (response.getStatus()) {
            case SUCCESS:
                swipeRefreshLayout.setRefreshing(false);
                if (response.getData() != null) {
                    onCharacterSuccess(response.getData());
                }
                break;
            case ERROR:
                swipeRefreshLayout.setRefreshing(false);
                Toast.makeText(getActivity(),response.getError().getMessage(),Toast.LENGTH_SHORT).show();
                break;
            case LOADING:
                swipeRefreshLayout.setRefreshing(true);
                break;
        }
    }

    private void onCharacterSuccess(List<Character> characters) {

        int diff = characters.size() - this.characters.size() ;

        this.characters = characters;

        CharacterAdapter adapter = (CharacterAdapter) recyclerView.getAdapter();
        adapter.setData(this.characters);

        validateButtonsVisibility((LinearLayoutManager) Objects.requireNonNull(recyclerView.getLayoutManager()));

        if(diff > 0 ) {

            if (diff < fetch) {
                getCharacters();
            } else {
                recyclerView.scrollToPosition(this.characters.size()-1);
            }
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        if(view.getId() == R.id.character_item_favorite_img){
            characterViewModel.setFavorite(position);
        } else {
            characterViewModel.setSelected(characters.get(position),position);
            Navigation.findNavController(view).navigate(R.id.characterDetailFragment);
        }
    }

    private RecyclerView.OnScrollListener setupScrollListener() {
        scrollListener = new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if( layoutManager != null) {
                    validateButtonsVisibility(layoutManager);
                }
            }
        };

        return scrollListener;
    }

    private void validateButtonsVisibility(@NonNull LinearLayoutManager layoutManager) {
        int first = layoutManager.findFirstVisibleItemPosition();
        int last = layoutManager.findLastVisibleItemPosition();
        int maxVisible = last-first;

        //toTop's Visibility
        if(first > maxVisible / 2){
            toTop.setVisibility(View.VISIBLE);
        } else {
            toTop.setVisibility(View.INVISIBLE);
        }

        //toBottom's Visibility
        if(last < characters.size() - maxVisible / 2){
            toBottom.setVisibility(View.VISIBLE);
        } else {
            toBottom.setVisibility(View.INVISIBLE);
        }
    }
}
