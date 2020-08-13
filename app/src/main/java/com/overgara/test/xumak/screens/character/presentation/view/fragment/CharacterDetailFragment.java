package com.overgara.test.xumak.screens.character.presentation.view.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.google.common.base.Joiner;
import com.overgara.test.xumak.R;
import com.overgara.test.xumak.base.BaseFragment;
import com.overgara.test.xumak.databinding.FragmentCharacterDetailBinding;
import com.overgara.test.xumak.presentation.viewmodel.state.StateData;
import com.overgara.test.xumak.screens.character.presentation.model.Character;
import com.overgara.test.xumak.screens.character.presentation.viewmodel.CharacterViewModel;

/**
 * Created By oscar.vergara on 14/08/2020
 */
public class CharacterDetailFragment extends BaseFragment {

    CharacterViewModel characterViewModel;

    FragmentCharacterDetailBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCharacterDetailBinding.inflate(getLayoutInflater(),container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        characterViewModel = new ViewModelProvider(getActivity()).get(CharacterViewModel.class);
        setInfo();
    }

    private void setInfo() {
        Character character = characterViewModel.getSelectedObs().getValue().getData();
        if(character != null){
            //binding.characterDetailNicknameTxt.setText(character.getNickname());
            binding.characterDetailStatusTxt.setText(character.getStatus());
            binding.characterDetailNameTxt.setText(character.getName());
            binding.characterDetailBirthdayTxt.setText(character.getBirthday());
            binding.characterDetailAppearanceTxt.setText(Joiner.on(", ").join(character.getAppearance()));
            binding.characterDetailOccupationTxt.setText(Joiner.on(", ").join(character.getOccupation()));
            binding.characterDetailStatusTxt.setText(character.getStatus());
            binding.characterDetailPortrayedTxt.setText(character.getPortrayed());

            if(binding.toolbarLayout != null){
                binding.toolbarLayout.setTitle(character.getNickname());
            } else {
                binding.toolbar.setTitle(character.getNickname());
            }

            if(!TextUtils.isEmpty(character.getImg())) {
                Glide.with(getActivity()).load(character.getImg())
                        .apply(new RequestOptions().transform(new RoundedCorners(50)))
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(binding.characterDetailCharacterImg);
            }

            if(!character.isFavorite()) {
                    binding.toolbar.getMenu().getItem(0).setIcon(getActivity().getDrawable(R.drawable.ic_unfavorite));
            }

            binding.toolbar.getMenu().getItem(0).setOnMenuItemClickListener(item -> {
                characterViewModel.setFavoriteSelected();
                return false;
            });

            characterViewModel.getSelectedObs().observe(getViewLifecycleOwner(),this::selectedObserve);

            binding.toolbar.setNavigationOnClickListener(v -> Navigation.findNavController(v).navigateUp());
        }

    }

    private void selectedObserve(StateData<Character> response){
        switch (response.getStatus()) {
            case SUCCESS:
                if(response.getData().isFavorite()) {
                    binding.toolbar.getMenu().getItem(0).setIcon(getActivity().getDrawable(R.drawable.ic_favorite));
                } else {
                    binding.toolbar.getMenu().getItem(0).setIcon(getActivity().getDrawable(R.drawable.ic_unfavorite));
                }
                break;
            case COMPLETE:
                break;
            case LOADING:
                break;
            case ERROR:
                Toast.makeText(getActivity(),response.getError().getMessage(),Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void onBackPressed(View view){
        requireActivity().onBackPressed();
    }
}
