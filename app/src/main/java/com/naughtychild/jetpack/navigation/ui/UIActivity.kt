package com.naughtychild.jetpack.navigation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.naughtychild.jetpack.R

class UIActivity : AppCompatActivity() {
    private lateinit var appbarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_i)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        appbarConfiguration = AppBarConfiguration.Builder(navController.graph).build()
        navController.addOnDestinationChangedListener { _, _, _ ->
            Toast.makeText(this, "lallala", Toast.LENGTH_SHORT).show()
        }
        NavigationUI.setupActionBarWithNavController(this, navController, appbarConfiguration)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            navController
        ) || super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            navController,
            appbarConfiguration
        ) || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_setting, menu)
        return true
    }
}