/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author Serkid
 */
import com.aylien.newsapi.*;
import com.aylien.newsapi.auth.*;
import com.aylien.newsapi.models.*;
import com.aylien.newsapi.parameters.*;
import com.aylien.newsapi.api.DefaultApi;

import java.util.*;
import org.json.*;

public class Main {

  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();

     // Configure API key authorization: app_id
    ApiKeyAuth app_id = (ApiKeyAuth) defaultClient.getAuthentication("app_id");
    app_id.setApiKey("536f8b2c");

    // Configure API key authorization: app_key
    ApiKeyAuth app_key = (ApiKeyAuth) defaultClient.getAuthentication("app_key");
    app_key.setApiKey("4d5a38c38bc964c615d850450a934308");

    DefaultApi apiInstance = new DefaultApi();

    StoriesParams.Builder storiesBuilder = StoriesParams.newBuilder();

    String title = "trump";
    String sortBy = "social_shares_count.facebook";
    List<String> language = new ArrayList<String>()  {{
      add("en");
    }};
    String since = "NOW-7DAYS";
    String until = "NOW";
    List<String> entities = new ArrayList<String>()  {{
      add("http://dbpedia.org/resource/Donald_Trump");
      add("http://dbpedia.org/resource/Hillary_Rodham_Clinton");
    }}; 
    
    
   
     
    storiesBuilder.setTitle(title);
    storiesBuilder.setSortBy(sortBy);
    storiesBuilder.setLanguage(language);
    storiesBuilder.setPublishedAtStart(since);
    storiesBuilder.setPublishedAtEnd(until);
    storiesBuilder.setEntitiesBodyLinksDbpedia(entities);
    

    try {
      Stories result = apiInstance.listStories(storiesBuilder.build());
      //System.out.println(result);
     List<Story> test = result.getStories();
    
     int cnt = 0;
     for (int i = 0; i < test.size(); i++) {
			String titlos = test.get(i).getTitle();
                        String writer = test.get(i).getAuthor().getName();
                        System.out.println("Title: "+ titlos + "  Writer " + writer);
            cnt= cnt+1;
		}
        System.out.println("The number of stories is "+cnt);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#listStories");
      e.printStackTrace();
    }
  }
}