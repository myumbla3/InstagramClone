package edu.citymail.instagramclone.fragments;


import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

import edu.citymail.instagramclone.LoginActivity;
import edu.citymail.instagramclone.Post;
import edu.citymail.instagramclone.R;

public class ProfileFragment extends PostsFragment {




    @Override
    protected void queryPosts() {
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        query.include(Post.KEY_USER);
        query.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser());
        query.setLimit(20);
        query.addDescendingOrder(Post.KEY_CREATED_KEY);
        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if (e != null){
                    Log.e(TAG, "Issue with getting posts",e);
                    return;
                }
                for (Post post: posts){
                    Log.i(TAG, "Post: " + post.getDescription() + ",username:" + post.getUser().getUsername());
                }
                allPosts.addAll(posts);
                adapter.notifyDataSetChanged();
            }
        });
    }

}
