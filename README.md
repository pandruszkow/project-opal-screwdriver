# project-opal-screwdriver
Gubbin number allocator

## What is this?
Auto-increment/Asset Tag As A Service, basically. POST a request, you get a newly minted identifier that's guaranteed to be unique among all the other IDs that this server had generated so far. 

## What inspired this?
Issue tracking systems that support alphanumeric ticket numbers like `FOO-123`. I was using such a system for my personal use, and I quickly noticed that I could use the ticket numbers as a short, unambiguous way to refer to certain complicated or multi-faceted concepts or TODOs. I decided that I want something like that for standalone use. 

## Why would I use this?
You could use it to generate a short, unique number or asset tag to assign to virtually anything digital or physical that you want to keep track of, and then cross-reference it in different places. You could give unique numbers/asset tags to:

1. Electronic devices in your company
1. Every item in your personal hobby collection
1. Every paper-based and digital bank statement, bill and invoice that you receive
1. Family recipes and important photos
1. Quotes and snippets you've collected from the Internet and various books/newspapers

Say goodbye to "the amazing recipe for eggs benedict that Auntie Carol gave me back in 2009", say hello to "recipe 103". Things are suddenly much easier to convey precisely.

## Isn't this a bit overcomplicated?
Maybe. It works for me.

