package com.example.android.listview

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.row_main.view.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)

        // Modifying the list and set an adapter on it
        listView.adapter = myCustomAdapter() // this needs to be my custom adapter telling my list what to render
    }

    // Create a custom adapter
    private class myCustomAdapter: BaseAdapter() {


        // Create an ArrayList for the names
        private val names = arrayListOf<String>(
            "Kobe Bryant", "Elon Musk", "Barack Obama", "Joe Rogan", "Sal Khan"
        )

        // Responsible for rendering out each row
        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {

            // Make the rowMain accessible outside of the if
            val rowMain: View

            // Check if convertView is null, meaning we have to inflate a new row
            if (convertView == null) {
                val layoutInflater = LayoutInflater.from(viewGroup!!.context)
                rowMain = layoutInflater.inflate(R.layout.row_main, viewGroup, false)

                val viewHolder = ViewHolder(rowMain.name_textView, rowMain.position_textview)
                rowMain.tag = viewHolder
            } else {
                // Well, we have our row as convertView, so just set rowMain as that view
                rowMain = convertView
            }

            val viewHolder = rowMain.tag as ViewHolder
            viewHolder.nameTextView.text = names.get(position)
            // Use string interpolation with a $ sign
            viewHolder.positionTextView.text = "Row number: $position"

            return rowMain
        }

        override fun getItem(position: Int): Any {
            return "TEST STRING"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        // Responsible for how many rows in my list
        override fun getCount(): Int {
            return names.size
        }

        // Create the ViewHolder class
        private class ViewHolder(val nameTextView: TextView, val positionTextView: TextView)
    }
}
