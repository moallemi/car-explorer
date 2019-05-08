package me.moallemi.sixt.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.moallemi.sixt.R
import me.moallemi.sixt.ui.browse.list.BrowseListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        supportFragmentManager?.beginTransaction()
            ?.replace(R.id.contentFrame, BrowseListFragment.getInstance())
            ?.commit()
    }
}
