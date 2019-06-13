package com.neosoft.rxjavaexample

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.view.LayoutInflater
import android.widget.TextView


class GitHubRepoAdapter:BaseAdapter() {
    val gitHubRepos = ArrayList<GitHubRepo>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

       // val view = convertView ?: createView(parent!!)
        val view = (if (convertView != null) convertView else createView(parent!!))
        val viewHolder:GitHubRepoViewHolder = view.tag as GitHubRepoViewHolder
        viewHolder.setGitHubRepo(getItem(position) as GitHubRepo)
        return view
    }

    override fun getItem(position: Int): Any? {
         //To change body of created functions use File | Settings | File Templates.
        if (position < 0 || position >= gitHubRepos.size){
            return null
        }else{
            return gitHubRepos.get(position)
        }
    }

    override fun getItemId(position: Int): Long {
         //To change body of created functions use File | Settings | File Templates.
        return position.toLong() // as Long
    }

    override fun getCount(): Int {
         //To change body of created functions use File | Settings | File Templates.
        return gitHubRepos.size
    }

    fun setGitHubRepos(repos : List<GitHubRepo>?){
        if (repos==null){
            return
        }
        gitHubRepos.clear()
        gitHubRepos.addAll(repos)
        notifyDataSetChanged()
    }

     fun createView(parent: ViewGroup): View {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_github_repo, parent, false)
        val viewHolder = GitHubRepoViewHolder(view)
        view.setTag(viewHolder)
        return view
    }


    companion object{
        class GitHubRepoViewHolder(view:View) {

            private val textRepoName: TextView
            private val textRepoDescription: TextView
            private val textLanguage: TextView
            private val textStars: TextView

            init{
                textRepoName = view.findViewById(R.id.text_repo_name) as TextView
                textRepoDescription = view.findViewById(R.id.text_repo_description) as TextView
                textLanguage = view.findViewById(R.id.text_language) as TextView
                textStars = view.findViewById(R.id.text_stars) as TextView
            }

            fun setGitHubRepo(gitHubRepo:GitHubRepo) {
                textRepoName.setText(gitHubRepo.name)
                textRepoDescription.setText(gitHubRepo.description)
                textLanguage.setText("Language: " + gitHubRepo.language)
                textStars.setText("Stars: " + gitHubRepo.stargazersCount)
            }
        }
    }


}