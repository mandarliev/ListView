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
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)
        // val redColor = Color.parseColor("#FF0000")
        // listView.setBackgroundColor(redColor)

        // Modifying the list and set an adapter on it
        listView.adapter = myCustomAdapter(this) // this needs to be my custom adapter telling my list what to render
    }

    // Create a custom adapter
    private class myCustomAdapter(context: Context) : BaseAdapter() {

        private val mContext: Context

        // Create an ArrayList for the names
        private val names = arrayListOf<String>(
            "Kobe Bryant", "Elon Musk", "Barack Obama", "Joe Rogan", "Sal Khan"
        )

        init {
            mContext = context
        }

        // Responsible for rendering out each row
        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.row_main, viewGroup, false)

            // Access the position TextView
            val positionTextView = rowMain.findViewById<TextView>(R.id.position_textview)
            // Use string interpolation with a $ sign
            positionTextView.text = "Row number: $position"

            // Access the name TextView
            val nameTextView = rowMain.findViewById<TextView>(R.id.name_textView)
            nameTextView.text = names.get(position)

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

    }
}
