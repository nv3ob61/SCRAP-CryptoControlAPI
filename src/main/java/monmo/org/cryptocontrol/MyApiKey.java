/* 
 * Copyright (C) 2021 mon_mode   0mon.mode@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package monmo.org.cryptocontrol;

/**
 *
 * @author nv3ob61
 */
public class MyApiKey {
  //add your api key here, from:
  // https://cryptocontrol.io/en/developers/apis

  // it's free!
  public static final String API_KEY = "DEF_API";

  public static final int KEY_LENGTH = 32;
  //control String
  public static final String DEF_API = "DEF_API";

  private String myKey;

  public MyApiKey() {

    myKey = API_KEY;
    if (!checkKey(myKey)) {
      System.out.println("PACO ERROR: Error, check MyApiKey -> String API_KEY,"
              + "maybe because it's DEF_API or a wrong value. This won't load "
              + "anything.. Sorry.");
    }
  }

  public static boolean checkKey(String mykey) {
    boolean isOk = false;

    if (mykey == null || mykey.equals(DEF_API)) {
      if (mykey != null && mykey.equals(DEF_API)) {
        System.out.println("  ..INFO: You have DEF_API as current API key. Check config values....");
      }
      throw new Error("No API key found. Register for an API key at https://cryptocontrol.io/apis");
    } else if (!checkLength(mykey.length())) {
      System.out.println("ERROR: The key is not a 32 length String...");
    } else {
      isOk = true;
    }

    return isOk;
  }

  public static boolean checkLength(int mykey) {
    return mykey == KEY_LENGTH;
  }

  public MyApiKey(String myKey) {
    this.myKey = myKey;
  }

  public String getMyKey() {
    return myKey;
  }

  public void setMyKey(String myKey) {
    if (myKey != null && myKey.equals(DEF_API) && myKey.length() == KEY_LENGTH) {
      this.myKey = myKey;
    }
  }
}
