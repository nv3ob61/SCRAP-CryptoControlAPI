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

import io.cryptocontrol.cryptonewsapi.CryptoControlApi;
import io.cryptocontrol.cryptonewsapi.models.Article;
import io.cryptocontrol.cryptonewsapi.models.CoinDetail;
import io.cryptocontrol.cryptonewsapi.models.Language;
import java.util.List;

/**
 *
 * @author nv3ob61
 */
public class NewMain {
// test purposes MAX_TITLE_LONG...
//  public static final int MAX_TITLE_LNG = 60;

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    MyApiKey apiKey = new MyApiKey();
    // Connect to the CryptoControl API
    CryptoControlApi api = new CryptoControlApi(apiKey.getMyKey());

    api.getTopNews(Language.SPANISH, new CryptoControlApi.OnResponseHandler<List<Article>>() {
      @Override
      public void onSuccess(List<Article> body) {
        for (Article article : body) {
          System.out.println(article.getTitle()
                  + "\n\n" + article.getDescription()
                  + "\n\n" + article.getPublishedAt()
                  + "\n\n-----------------------------\n");
        }
      }

      @Override
      public void onFailure(Exception e) {
        System.out.println("OOOPS! Spanish");
      }
    });

// Get top crypto news
    api.getTopNews(new CryptoControlApi.OnResponseHandler<List<Article>>() {
      @Override
      public void onSuccess(List<Article> body) {
        for (Article article : body) {
          System.out.println(article.getTitle());
          System.out.println(article.getPublishedAt());
          System.out.println();
          System.out.println();
          System.out.println("---");
        }
      }

      @Override
      public void onFailure(Exception e) {
        System.out.println("OOOPS cryptonews!");
      }
    });

    api.getLatestNewsByCoin("nano", new CryptoControlApi.OnResponseHandler<List<Article>>() {
      @Override
      public void onSuccess(List<Article> t) {
        for (Article feed : t) {
          System.out.println("---");
          System.out.println(feed.getTitle());
          System.out.println(feed.getPublishedAt());
          System.out.println("HOT: " + feed.getActivityHotness());
        }
      }

      @Override
      public void onFailure(Exception excptn) {
        System.out.println("opps! nano-news");
      }

    });

    // Get rich metadata (wallets, blockexplorers, twitter handles etc..) for ethereum
    api.getCoinDetails("nano", new CryptoControlApi.OnResponseHandler<CoinDetail>() {
      @Override
      public void onSuccess(CoinDetail body) {
        System.out.println(body.getDescription());
        System.out.println("");
        System.out.println(body.getSubreddits());
        System.out.println("---");
        for (CoinDetail.Link link : body.getLinks()) {
          System.out.println(link.getLink() + " - " + link.getName());
          System.out.println("________________");
        }
      }

      @Override
      public void onFailure(Exception e) {
        System.out.println("OOOOPS! nano-coinDetails");
      }
    });
  }

}
