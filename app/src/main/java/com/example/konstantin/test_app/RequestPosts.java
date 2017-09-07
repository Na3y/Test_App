package com.example.konstantin.test_app;


import android.content.Context;
import android.os.AsyncTask;

import com.example.konstantin.test_app.POJO.Posts;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Response;

class RequestPosts extends AsyncTask<String, Object, PostAdapter> {

    private Context context;
    private String token;
    private ArrayList<Item> items = new ArrayList<Item>();
    private PostAdapter postAdapter;

    RequestPosts(Context context, String token){
        this.context = context;
        this.token = token;
    }


    @Override
    protected PostAdapter doInBackground(String... category) {
        try {
            Response<Posts> posts = App.getApi().getPost(this.token, category[0]).execute();
            if (items!=null){items.clear();}
            for (int i = 0; i < posts.body().getPosts().size(); i++){
                String name = posts.body().getPosts().get(i).getName();
                int id_post = posts.body().getPosts().get(i).getId();
                String descr = posts.body().getPosts().get(i).getTagline();
                String upvote = "upvote: "+String.valueOf(posts.body().getPosts().get(i).getVotesCount());
                String imageurl = posts.body().getPosts().get(i).getThumbnail().getImageUrl();
                items.add(new Item(name, descr, upvote, id_post, imageurl));
            }
            postAdapter = new PostAdapter(context, items);
            postAdapter.notifyDataSetChanged();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return postAdapter;
    }



    @Override
    protected void onPostExecute(PostAdapter result) {
        super.onPostExecute(result);



    }

    ArrayList<Item> getItems(){
        return this.items;
    }

}
