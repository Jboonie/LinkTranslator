# LinkTranslator

A simple lightweight application that allows you to translate HTML code across mirrored deployments where content is the same but but the relative links to the content are different.

### Use case:
Let us say that you maintain a department application and a department website.  The website and the application cannot reside on the same network.  The application contains a local copy of your organization's corporate policy and so does your website.  You have to maintain two sets of documents that are functionally identical but they reside in different locations and the links inside the policy documents are different.  Updating documents in one enviornment is trivial but when you need to quickly move changes from one enviornment to the other all of the links break.  LinkTranslator will allow you to define key phrases that should be swapped in a block of text.  This allows you to define a relation between a link in one system and a link in your other system and quickly swap a document that references these links from one enviornment to the next very quickly.
