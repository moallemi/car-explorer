package me.moallemi.carexplorer.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import me.moallemi.carexplorer.R
import me.moallemi.carexplorer.extension.inTransaction
import me.moallemi.carexplorer.ui.browse.list.BrowseListFragment
import me.moallemi.carexplorer.ui.browse.map.BrowseMapFragment

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        bottomNavigationView.setOnNavigationItemSelectedListener(this)

        if (savedInstanceState == null) {
            bottomNavigationView.selectedItemId = R.id.browseListFragment
        }
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.browseListFragment -> supportFragmentManager.inTransaction {
                replace(R.id.contentFrame, BrowseListFragment.getInstance())
            }
            R.id.browseMapFragment -> supportFragmentManager.inTransaction {
                replace(R.id.contentFrame, BrowseMapFragment.getInstance())
            }
        }
        return true
    }
}
