package com.example.brochill

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TweetAdaptor(tweets: ArrayList<String>) : RecyclerView.Adapter<TweetAdaptor.ViewHolder>() {
var tweet=tweets
    inner class ViewHolder(itemVIew: View):RecyclerView.ViewHolder(itemVIew){
        var message= itemVIew.findViewById<TextView>(R.id.todo_text)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)

            .inflate(R.layout.tweet_adaptor, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.message.text= tweet[position]
    }

    override fun getItemCount(): Int {
       return tweet.size
    }


}