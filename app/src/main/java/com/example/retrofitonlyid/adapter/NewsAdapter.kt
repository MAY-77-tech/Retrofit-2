package com.example.retrofitonlyid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitonlyid.R
import com.example.retrofitonlyid.model.Article
import com.example.retrofitonlyid.model.News
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(var articleList: List<Article>):RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(article: Article){
            itemView.txtTitle.text = article.title
            itemView.txtContent.text = article.content

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
       return NewsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false))

    }

    override fun getItemCount(): Int {
        return articleList.size

    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(articleList[position])
    }
}