package com.example.twitter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.twitter.adapter.FeedAdapter
import com.example.twitter.adapter.StoryAdapter
import com.example.twitter.model.Post
import com.example.twitter.model.Story

class MainActivity : AppCompatActivity() {

    lateinit var recyclerStory: RecyclerView
    lateinit var recyclerFeed: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    fun initViews() {
        recyclerStory = findViewById(R.id.recyclerStory)
        recyclerStory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerFeed = findViewById(R.id.recyclerFeed)
        recyclerFeed.layoutManager = GridLayoutManager(this, 1)

        refreshStoryAdapter(getAllStories())
        refreshFeedAdapter(getAllFeeds())
    }

    fun refreshStoryAdapter(chats: ArrayList<Story>) {
        val adapter = StoryAdapter(this, chats)
        recyclerStory.adapter = adapter
    }

    fun refreshFeedAdapter(posts: ArrayList<Post>) {
        val adapter = FeedAdapter(this, posts)
        recyclerFeed.adapter = adapter
    }

    fun getAllStories() : ArrayList<Story> {
        val stories: ArrayList<Story> = ArrayList()
        stories.add(Story(R.drawable.im_sample1, "Qobilov Kamron"))
        stories.add(Story(R.drawable.im_sample2, "Xushvaqtov Azizbek"))
        stories.add(Story(R.drawable.im_sample3, "Qobilov Kamron"))
        stories.add(Story(R.drawable.im_sample4, "Qobilov Kamron"))
        stories.add(Story(R.drawable.im_sample5, "Qobilov Kamron"))
        stories.add(Story(R.drawable.im_sample6, "Qobilov Kamron"))

        return stories
    }

    fun getAllFeeds(): ArrayList<Post> {
        val posts: ArrayList<Post> = ArrayList()
        posts.add(Post(R.drawable.im_sample1, "Qobilov Kamron", R.drawable.im_post1))
        posts.add(Post(R.drawable.im_sample2, "Qobilov Kamron", R.drawable.im_post4))
        posts.add(Post(R.drawable.im_sample3, "Qobilov Kamron", R.drawable.im_post2))
        posts.add(Post(R.drawable.im_sample4, "Qobilov Kamron", R.drawable.im_post4))
        posts.add(Post(R.drawable.im_sample5, "Qobilov Kamron", R.drawable.im_post2))
        posts.add(Post(R.drawable.im_sample6, "Qobilov Kamron", R.drawable.im_post1))

        return posts
    }
}