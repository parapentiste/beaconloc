/*
 *
 *  Copyright (c) 2015 SameBits UG. All rights reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.samebits.beacon.locator.ui.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.preference.Preference;
import android.support.v7.preference.CheckBoxPreference;

import com.samebits.beacon.locator.R;
import com.samebits.beacon.locator.model.IManagedBeacon;
import com.samebits.beacon.locator.util.Constants;

/**
 * Created by vitas on 20/12/15.
 */
public class BeaconEventPageFragment extends PageBeaconFragment {


    public static BeaconEventPageFragment newInstance(IManagedBeacon beacon, int page) {
        BeaconEventPageFragment detailFragment = new BeaconEventPageFragment();
        Bundle args = new Bundle();
        args.putInt(Constants.ARG_PAGE, page);
        if (beacon != null) {
            // detailFragment.setBeacon(beacon);
            args.putParcelable(Constants.ARG_BEACON, (Parcelable) beacon);
        }
        detailFragment.setArguments(args);
        return detailFragment;
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        this.addPreferencesFromResource(R.xml.preferences_beacon_event);
    }

    @Override
    public boolean onPreferenceTreeClick(Preference preference) {

        String key = preference.getKey();
        if (key.equals("be_event_enter_region")) {
            //Reset other items
            ((CheckBoxPreference) findPreference("be_event_leaves_region")).setChecked(false);
            ((CheckBoxPreference) findPreference("be_event_near_you")).setChecked(false);
        } else if (key.equals("be_event_leaves_region")) {
            ((CheckBoxPreference) findPreference("be_event_enter_region")).setChecked(false);
            ((CheckBoxPreference) findPreference("be_event_near_you")).setChecked(false);
        } else {
            ((CheckBoxPreference) findPreference("be_event_leaves_region")).setChecked(false);
            ((CheckBoxPreference) findPreference("be_event_enter_region")).setChecked(false);
        }

        return super.onPreferenceTreeClick(preference);
    }

    @Override
    protected void setData() {

    }

}
