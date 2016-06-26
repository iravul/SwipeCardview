# SwipeCardview for listing item or products

SwipeCardview is a recyclerview that lists products, items or etc. with using cardview. Also it aligns the card to center.

  - Android API 14+
  - Optimized for the all screen sizes
  - Easy to use
  - Image loading with Ion library

### Demo

You can try sample from source codes. Also you can test from http://iravul.com/swipecardview/


### Version
1.0

### Tech

SwipeCardview uses some open source projects to work properly:

* [Ion] - Android Asynchronous Networking and Image Loading
* [Center Lock RecyclerView]


### Usage

Initialize your own recyclerview in Activity or Fragment. Then use SwipeCardAdapter to show values on your recyclerview.

Use SwipeCardModel List for loading data. 
```java
List<SwipeCardModel> swipeCardModels = new ArrayList<>();

//dummydata
for(int i=0;i<=10;i++){
    SwipeCardModel swipeCardModel = new SwipeCardModel();
    swipeCardModel.setId("ID-"+i);
    swipeCardModel.setTitle("Product-"+i);
    swipeCardModel.setDescription("ProductDesc-"+i);
    swipeCardModel.setPrice(i*10+" Euro");
    swipeCardModel.setPhotoUrl("https://s-media-cache-ak0.pinimg.com/736x/a3/99/24/a39924a3fcb7266ff7360af8a6ba2e98.jpg");
    swipeCardModels.add(swipeCardModel);
}
```

Set values to SwipeCardAdapter.
```java
SwipeCardAdapter swipeCardAdapter = new SwipeCardAdapter(MainActivity.this, swipeCardModels, MainActivity.this);
LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
recyclerView.setLayoutManager(layoutManager);
recyclerView.setAdapter(swipeCardAdapter);
```

Implement RecyclerViewClickListener and get  onclick events via interface. 

```java
public class MainActivity extends Activity implements RecyclerViewClickListener 
```
```java
@Override
    public void recyclerViewListClicked(View v, int position) {
        //onclick events.
    }
```

License
----
Copyright 2016 Ergin Kucukiravul

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.





   [Ion]: <https://github.com/koush/ion>
   [Center Lock RecyclerView]: <https://github.com/humblerookie/centerlockrecyclerview>
