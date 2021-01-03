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

  //control String
  private String defApi = "DEF_API";

  private String myKey;

  public MyApiKey() {

    myKey = API_KEY;
    defApi = myKey;
    if (myKey == null || myKey.equals("DEF_API")) {
      throw new Error("No API key found. Register for an API key at https://cryptocontrol.io/apis");
    }

  }

  public MyApiKey(String myKey) {
    this.myKey = myKey;
  }

  public String getMyKey() {
    return myKey;
  }

  public void setMyKey(String myKey) {
    if (myKey == null) {
      throw new Error("No API key found. Register for an API key at https://cryptocontrol.io/apis");
    } else {
      this.myKey = myKey;
    }
  }

}
