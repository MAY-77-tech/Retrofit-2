package com.example.retrofitonlyid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitonlyid.adapter.NewsAdapter
import com.example.retrofitonlyid.api.NewApiInterface
import com.example.retrofitonlyid.model.Article
import com.example.retrofitonlyid.model.News
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_news.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getArticle()

    }

    fun loadArticleList(articleList: List<Article>){
        var newsAdapter = NewsAdapter(articleList)
       recyclerNews.layoutManager = LinearLayoutManager(this)
        recyclerNews.adapter = newsAdapter
    }


    fun getArticle() {
        var BASE_URL = "http://newsapi.org/v2/"
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var retrofitService = retrofit.create(NewApiInterface::class.java)

        var apiCall = retrofitService.getArticle("us","business","c3e71d1ca036462089b9ce79b7a28414")

        apiCall.enqueue(object :
            Callback<News> {
            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("Failure>>>>>>>>>>", t.toString())

            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                var articleList = response.body()?.articles
                Log.d("Response>>>>>>>>>>", articleList.toString())
                if (articleList != null) {
                    loadArticleList(articleList)
                }
//                if (postList != null) {
//                    loadpostList(postList as ArrayList<Post>)
//                }
            }

        })

    }
}
