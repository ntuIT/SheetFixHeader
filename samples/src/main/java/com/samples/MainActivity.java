package com.samples;

import android.app.ActionBar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();

		B b[] = new B[] {
				new B(getString(R.string.simple_adapter), SimpleTable.class),
				new B(getString(R.string.style_adapter) + " With coordinates position item", StyleTable.class),
				new B(getString(R.string.family_adapter), FamilyTable.class),
		};
		setListAdapter(new ArrayAdapter<B>(this, android.R.layout.simple_list_item_1, android.R.id.text1, b));
	}

	private void initView() {
		ActionBar actionBar;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB
		) {
			actionBar = getActionBar();
		}
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		startActivity(new Intent(this, ((B) l.getItemAtPosition(position)).class1));
	}

	private class B {
		private final String string;
		private final Class<? extends Activity> class1;

		B(String string, Class<? extends Activity> class1) {
			this.string = string;
			this.class1 = class1;
		}

		@Override
		public String toString() {
			return string;
		}
	}
}
