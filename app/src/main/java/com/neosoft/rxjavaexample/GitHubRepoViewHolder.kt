//package com.neosoft.rxjavaexample
//
//import android.view.View
//import android.widget.TextView
//
// class GitHubRepoViewHolder(view:View) {
//
//    private val textRepoName: TextView
//    private val textRepoDescription:TextView
//    private val textLanguage:TextView
//    private val textStars:TextView
//
//    init{
//        textRepoName = view.findViewById(R.id.text_repo_name) as TextView
//        textRepoDescription = view.findViewById(R.id.text_repo_description) as TextView
//        textLanguage = view.findViewById(R.id.text_language) as TextView
//        textStars = view.findViewById(R.id.text_stars) as TextView
//    }
//
//    fun setGitHubRepo(gitHubRepo:GitHubRepo) {
//        textRepoName.setText(gitHubRepo.name)
//        textRepoDescription.setText(gitHubRepo.description)
//        textLanguage.setText("Language: " + gitHubRepo.language)
//        textStars.setText("Stars: " + gitHubRepo.stargazersCount)
//    }
//}