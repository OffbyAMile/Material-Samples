package com.offbyamilestudios.example.material.components;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

	private BottomAppBar bottomAppBar;
	private FloatingActionButton mFab;

	@Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(com.offbyamilestudios.example.material.components.R.layout.activity_main);
	  Toolbar toolbar = findViewById(com.offbyamilestudios.example.material.components.R.id.toolbar);

    bottomAppBar = findViewById(com.offbyamilestudios.example.material.components.R.id.bottom);
    mFab = findViewById(com.offbyamilestudios.example.material.components.R.id.fabby);
	  MaterialButton btn = findViewById(com.offbyamilestudios.example.material.components.R.id.material_btn);

    setSupportActionBar(bottomAppBar);
    bottomAppBar.setNavigationIcon(com.offbyamilestudios.example.material.components.R.drawable.ic_menu);
    btn.setOnClickListener(
			new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					mFab.hide(
							new FloatingActionButton.OnVisibilityChangedListener() {

								@Override
								public void onHidden(FloatingActionButton mFab) {
									super.onHidden(mFab);

								toggleFabAlignment();
								bottomAppBar.replaceMenu(
										bottomAppBar.getFabAlignmentMode() == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER ?
											com.offbyamilestudios.example.material.components.R.menu.bottom_menu : com.offbyamilestudios.example.material.components.R.menu.bottom_menu_two
								);
								mFab.setImageResource(
										bottomAppBar.getFabAlignmentMode() == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER ?
												com.offbyamilestudios.example.material.components.R.drawable.ic_add : com.offbyamilestudios.example.material.components.R.drawable.triangle
								);
								mFab.show();
							}
						}
					);
					invalidateOptionsMenu();
					bottomAppBar.setNavigationIcon(
							bottomAppBar.getNavigationIcon() != null ? null :
									getDrawable(com.offbyamilestudios.example.material.components.R.drawable.ic_menu)
					);

				}
			}
		);
    }

			private void toggleFabAlignment() {
					this.bottomAppBar.setFabAlignmentMode(bottomAppBar.getFabAlignmentMode() ^ 1);
			}
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
  		getMenuInflater().inflate(com.offbyamilestudios.example.material.components.R.menu.bottom_menu, menu);
  		return true;
		}

		@Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle on Touches here
            switch (item.getItemId()) {
				case android.R.id.home:
					// Instantiate the bottom drawer to come up
					new com.offbyamilestudios.example.material.components.BottomNavigationDrawerFragment().show(getSupportFragmentManager(), "menu");

					break;

				case com.offbyamilestudios.example.material.components.R.id.action_search:
					toast(this, "Refresh");
					com.offbyamilestudios.example.material.components.AnimationHelper.animateFabShow(mFab);
					mFab.setImageResource(com.offbyamilestudios.example.material.components.R.drawable.ic_refresh);
					break;

				case com.offbyamilestudios.example.material.components.R.drawable.ic_favorite:
					com.offbyamilestudios.example.material.components.AnimationHelper.animateFabShow(mFab);
					bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
					mFab.setImageResource(com.offbyamilestudios.example.material.components.R.drawable.ic_favorite);
					toast(this, "Rate");
					break;

				case com.offbyamilestudios.example.material.components.R.id.action_settings:
					toast(this, "Settings");
					bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
            		break;
            }
			return true;
        }
        private void toast(Context context , String message) {
  		Toast toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
				toast.setGravity(Gravity.BOTTOM, 0, 365);
				toast.show();
	  }

}

