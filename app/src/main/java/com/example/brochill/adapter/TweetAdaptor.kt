package com.example.brochill.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.brochill.R
import com.example.brochill.activity.TweetMessage

class TweetAdaptor(tweets: ArrayList<String>) : RecyclerView.Adapter<TweetAdaptor.ViewHolder>() {
var tweet=tweets
    inner class ViewHolder(itemVIew: View):RecyclerView.ViewHolder(itemVIew){
        var message= itemVIew.findViewById<TextView>(R.id.todo_text)
        var context=itemVIew.context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.tweet_adaptor, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.message.text= tweet[position]
        holder.message.setOnClickListener {
            var intent= Intent(holder.context, TweetMessage::class.java)
            intent.putExtra("Body", tweet[position])
            holder.context.startActivity(intent)

        }
        setAnimation(holder)
    }
    private fun setAnimation(holder: ViewHolder) {
        val animation = AnimationUtils.loadAnimation(holder.context, android.R.anim.slide_in_left)
        holder.itemView.startAnimation(animation)
    }
    override fun getItemCount(): Int {
       return tweet.size
    }


}