package com.neosoft.rxjavaexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import rx.Observer
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity:AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName
    private val adapter:GitHubRepoAdapter =  GitHubRepoAdapter()
    lateinit var subscription: Subscription

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val listView = findViewById<ListView>(R.id.list_view_repos)
        listView.adapter = adapter

        val editTextUsername: EditText =  findViewById(R.id.edit_text_username)
        val buttonSearch: Button =  findViewById(R.id.button_search)
        buttonSearch.setOnClickListener {
            val username:String = editTextUsername.getText().toString()
            if (!TextUtils.isEmpty(username)){
                getStarredRepos(username)
            }
        }
    }

    fun getStarredRepos(username:String){
        subscription = GitHubClient.getInstance().getStarredRepos(username).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(object :Observer<List<GitHubRepo>>{
            override fun onError(e: Throwable?) {
                e?.printStackTrace()
                Log.d(TAG, "In onError()")
            }

            override fun onNext(gitHubRepos: List<GitHubRepo>?) {
                 //To change body of created functions use File | Settings | File Templates.
                Log.d(TAG, "In onNext()")
                adapter.setGitHubRepos(gitHubRepos)
            }

            override fun onCompleted() {
                 //To change body of created functions use File | Settings | File Templates.
                Log.d(TAG, "In onCompleted()")
            }
        })
    }

    override fun onDestroy() {

        if (subscription!=null && !subscription.isUnsubscribed){
            subscription.unsubscribe()
        }
        super.onDestroy()

    }

}