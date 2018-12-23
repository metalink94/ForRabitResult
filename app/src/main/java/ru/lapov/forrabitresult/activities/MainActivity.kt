package ru.lapov.forrabitresult.activities

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import ru.lapov.forrabitresult.R
import ru.lapov.forrabitresult.fragments.LoadingDialog
import ru.lapov.forrabitresult.listadapter.ListAdapterImpl
import ru.lapov.forrabitresult.listadapter.ListBuilder
import ru.lapov.forrabitresult.listadapter.ListBuilderImpl
import ru.lapov.forrabitresult.models.DividerItemModel
import ru.lapov.forrabitresult.models.RowItemModel

class MainActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener,
    View.OnClickListener {

    lateinit var adapter: ListAdapterImpl
    val builder: ListBuilderImpl = ListBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)
        initList()
        addList()
    }

    private fun initList() {
        list.layoutManager = LinearLayoutManager(this)
        builder.setRecycler(list)
        builder.setOnClickListener(this)
        adapter = builder.build()
        list.adapter = adapter.getRecyclerViewAdapter()
    }

    private fun addList() {
        adapter.addItem(DividerItemModel(getString(R.string.soccer_israel)))
        adapter.addItem(
            RowItemModel(
                "92'", "Rennais\n" +
                        "Nimes\n" +
                        "Draw", "1:2 (0:0)",
                "-/-", "-/-", "-/-", "+0"
            )
        )

        adapter.addItem(DividerItemModel(getString(R.string.soccer_france)))
        adapter.addItem(
            RowItemModel(
                "54'", "Strasbourg\n" +
                        "Nice\n" +
                        "Draw", "2:0 (2:0)",
                "1.07", "31", "15", "+15"
            )
        )
        adapter.addItem(
            RowItemModel(
                "58'", "Stras-bourg\n" +
                        "Nice\n" +
                        "Draw", "1:0 (1:0)",
                "1.18", "17", "6.8", "+19"
            )
        )
        adapter.addItem(
            RowItemModel(
                "47'", "Rennais\n" +
                        "Nimes\n" +
                        "Draw", "3:0 (2:0)",
                "-/-", "-/-", "-/-", "+0"
            )
        )
        adapter.addItem(DividerItemModel(getString(R.string.soccer_spain)))
        adapter.addItem(
            RowItemModel(
                "80'", "Calahorra СD\n" +
                        "Tudelano\n" +
                        "Draw", "1:1 (1:0)",
                "3.5", "8.5", "1.42", "+9"
            )
        )
        adapter.addItem(DividerItemModel(getString(R.string.soccer_niderland)))
        adapter.addItem(
            RowItemModel(
                "53'", "Excelsior\n" +
                        "Heracles Almelo\n" +
                        "Draw", "0:2 (0:2)",
                "24", "1.06", "15", "+19"
            )
        )
        adapter.addItem(
            RowItemModel(
                "58'", "Stras-bourg\n" +
                        "Nice\n" +
                        "Draw", "1:0 (1:0)",
                "1.18", "17", "6.8", "+19"
            )
        )
        adapter.addItem(
            RowItemModel(
                "47'", "Rennais\n" +
                        "Nimes\n" +
                        "Draw", "3:0 (2:0)",
                "-/-", "-/-", "-/-", "+0"
            )
        )
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_cricket, R.id.nav_bandy, R.id.nav_baseball,
                R.id.nav_basketball, R.id.nav_biathlon, R.id.nav_boxing,
                R.id.nav_football, R.id.nav_formula, R.id.nav_racing,
                R.id.nav_soccer, R.id.nav_tennis -> {
                showProgressDialog()
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun showProgressDialog() {
        supportFragmentManager.beginTransaction()
            .add(LoadingDialog(), "").commitAllowingStateLoss()
    }

    override fun onClick(view: View) {

    }
}
