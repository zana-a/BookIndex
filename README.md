# Book Index

This program finds all the pages that a set of words occurs.

There is no main method nor main class so please use the `BookTest` class to run the tests which demonstrates that the
program is working.

In order to test, you can use the gradle wrapper.

Here is an example:

```sh
$./gradlew test
```

## v2

This new version is vastly superior to the original as we do not iterate over our HashMap twice. This was done 
previously to remove any empty index entry.

Now, we are being careful to add an item to the HashMap (and into the HashSet) only when it is required.

I have also used HashSets more in this example because the underlying functionality for lookup and insertion is O(1).
Although in worst case scenario this lookup could be O(n) but on average this should be O(1) which suffices for this 
small example. I highly doubt each page will contain any more than 1000-2000 plus words and we most likely won't query
for a large set of keywords either.

Finally, I also added a check to see if the queried words are empty. If it is, there is no reason to go through each 
page and do extra computation (which the result will eventually end up as an empty Index object anyway).

To follow some OOP patterns, I also moved the insertion of the HashMap into an Index class. This helps with cleaner code
and separation of logic.

The test class was also improved, although I did not want to spend too much time on it. 

> The only thing here that I am not happy about is the fact that we have to split the content of the page which is going
> to slow down the algorithm. Realistically speaking, I could change the content from a String to a List<String> but 
> this is a business requirement issue. In real life words will most likely be in some byte format rather than a list or
> array.
