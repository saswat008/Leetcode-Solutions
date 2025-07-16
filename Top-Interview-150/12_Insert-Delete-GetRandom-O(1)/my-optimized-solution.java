/*
The most common use cases of Insert Delete GetRandom O(1) are as follows:

Caching: Caching is a way to store frequently accessed data in a temporary location so that it can be accessed quickly. For example, a web browser might cache recently visited websites so that they can load faster the next time you visit them. Insert Delete GetRandom O(1) can be used to implement a cache data structure that allows you to quickly insert, delete, and retrieve cached items.

In-memory databases: In-memory databases are databases that store data in main memory instead of on disk. This makes them much faster than traditional databases, but it also means that they can only store a limited amount of data. Insert Delete GetRandom O(1) can be used to implement an in-memory database that allows you to quickly insert, delete, and retrieve data.

Random sampling: Random sampling is the process of selecting a random subset of a population. This is useful for a variety of tasks, such as getting a representative sample of public opinion or conducting a scientific experiment. Insert Delete GetRandom O(1) can be used to implement a random sampling algorithm that allows you to quickly select a random subset of data.

Load balancing: Load balancing is the process of distributing traffic across multiple servers to improve performance and reliability. Insert Delete GetRandom O(1) can be used to implement a load balancer that assigns incoming requests to servers in a random order.

Shuffle: Shuffling is the process of arranging a set of items in a random order. This is useful for a variety of tasks, such as shuffling a deck of cards or creating a random playlist of songs. Insert Delete GetRandom O(1) can be used to implement a shuffling algorithm that allows you to quickly shuffle a set of items.

Here are some specific examples of real-world applications that use Insert Delete GetRandom O(1):

Google search: Google uses Insert Delete GetRandom O(1) to implement its search index. This allows Google to quickly insert, delete, and retrieve web pages from its index, which is essential for providing fast and accurate search results.
Facebook newsfeed: Facebook uses Insert Delete GetRandom O(1) to implement its newsfeed. This allows Facebook to quickly show you stories from your friends and family, even if they have a large number of friends.
Twitter timeline: Twitter uses Insert Delete GetRandom O(1) to implement its timeline. This allows Twitter to quickly show you tweets from the people you follow, even if they tweet frequently.
Netflix recommendations: Netflix uses Insert Delete GetRandom O(1) to implement its recommendation system. This allows Netflix to quickly recommend movies and TV shows that you are likely to enjoy, based on your viewing history.
Spotify playlists: Spotify uses Insert Delete GetRandom O(1) to implement its playlists. This allows you to quickly add and remove songs from your playlists, and to shuffle your playlists in a random order.
Overall, Insert Delete GetRandom O(1) is a versatile data structure that can be used to implement a wide variety of real-world applications. It is especially useful for applications that need to quickly insert, delete, and retrieve data, or that need to generate random samples of data.

Approach:

The order of elements is not important in the data structure. If we use an array as the data structure, insertion at the end will be in O(1) time but searching whether the element is already present in the array will take O(N) time. 
Removal of the element will require searching for the element which will take O(N) time and left shifting the subsequent array elements will also take O(N) time. Getting random element will take O(1) time using the rand() function. 
So, we need some additional data structure that allows us to locate the array index for removal and also to search whether the element is already present or not. This data structure should do these tasks in average O(1) time. Hashmap fulfils our requirements.

Algorithm:

Initialize two data structures:

a: An array to store elements.
m: A map to associate elements with their indices in the array.
Insertion (insert method):

Check if the value is already in the map (m).
If it's not in the map:
Add the value to the end of the array.
Store the value's index in the map (m).
Return true to indicate successful insertion.
If it's already in the map, return false.
Removal (remove method):

Check if the value is in the map (m).
If it's not in the map, return false (the value is not in the data structure).
If it's in the map:
Get the index of the value to be removed.
Replace the value at that index with the last value in the array.
Remove the last element from the array.
Update the index of the last element in the map to the index of the removed element.
Remove the entry for the removed value from the map.
Return true to indicate successful removal.
Get a Random Element (getRandom method):

Generate a random index within the range of valid indices in the array (from 0 to the size of the array minus 1).
Return the element at the randomly generated index.
The class allows you to insert elements, remove elements, and retrieve a random element, all with an average time complexity of O(1).
*/

class RandomizedSet {
    List<Integer> randomList;
    Map<Integer, Integer> randomMap;
    int listSize;

    public RandomizedSet() {
        this.randomList = new ArrayList<Integer>();
        this.randomMap = new HashMap<Integer, Integer>();
        this.listSize = 0;
    }
    
    public boolean insert(int val) {
        if(randomMap.containsKey(val)) {
            return false;
        } else {
            randomList.add(val);
            randomMap.put(val,listSize);
            listSize++;
            return true;
        }
    }
    
    public boolean remove(int val) {
        if (randomMap.containsKey(val)) {
            int index = randomMap.get(val);
            int newVal = randomList.get(listSize-1);
            Collections.swap(randomList, index, listSize-1);
            randomMap.put(newVal, index);
            randomList.remove(listSize-1);
            randomMap.remove(val);
            listSize--;
            return true;
        } else {
            return false;
        }
    }
    
    public int getRandom() {
        int index = (int) (Math.random()*listSize);
        return randomList.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */


// Time: O(1)
// Space: O(n)
