package com.overgara.test.xumak.screens.character.presentation.view.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.overgara.test.xumak.R;
import com.overgara.test.xumak.screens.character.presentation.model.Character;
import com.overgara.test.xumak.screens.character.presentation.view.listener.CharacterClickListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created By oscar.vergara on 13/08/2020
 */
public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> implements View.OnClickListener {

    private List<Character> characters = new ArrayList<>();
    public CharacterClickListener clickListener;
    private int position;

    @Inject
    public CharacterAdapter(CharacterClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setData(List<Character> characters){
        this.characters = characters;
        notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.character_adapter_item, parent, false);
        return new ViewHolder(view, parent.getContext(), position);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        this.position = position;
        Character character = characters.get(position);
        if(!TextUtils.isEmpty(character.getImg())) {
            Glide.with(holder.context).load(character.getImg())
                    .apply(new RequestOptions().transform(new RoundedCorners(70)))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.characterItemImg);
        }
        holder.characterItemNameTxt.setText(character.getName());
        holder.characterItemNicknameTxt.setText(character.getNickname());
        if(character.isFavorite()){
            holder.characterItemFavoriteImg.setBackground(holder.context.getDrawable(R.drawable.ic_favorite));
        } else {
            holder.characterItemFavoriteImg.setBackground(holder.context.getDrawable(R.drawable.ic_unfavorite));
        }
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public Context context;
        TextView characterItemNameTxt;
        TextView characterItemNicknameTxt;
        ImageView characterItemImg;
        ImageView characterItemFavoriteImg;
        ConstraintLayout characterItemLayout;
        int position;

        public ViewHolder(View view, Context context, int position) {
            super(view);
            this.position = position;
            this.context = context;
            this.characterItemFavoriteImg = view.findViewById(R.id.character_item_favorite_img);
            this.characterItemImg = view.findViewById(R.id.character_item_img);
            this.characterItemNameTxt = view.findViewById(R.id.character_item_name_txt);
            this.characterItemNicknameTxt = view.findViewById(R.id.character_item_nickname_txt);
            this.characterItemLayout = view.findViewById(R.id.character_item_layout);
            characterItemFavoriteImg.setOnClickListener(this::onClick);
            view.setOnClickListener(this::onClick);
        }

        public void onClick(View v) {
            clickListener.onItemClick(v,getAdapterPosition());
        }
    }
}
