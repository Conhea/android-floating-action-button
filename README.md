FloatingActionButton
====================
Yet another library for drawing [Material Design promoted actions](http://www.google.com/design/spec/patterns/promoted-actions.html).

Credits
=======
I used [FloatingActionButton](https://github.com/bohsen/android-floating-action-button) library 
by [Jerzy Chalupski](https://github.com/futuresimple) as a base for development.
As this wasn't being actively developed any longer I've decided to incorperate a 
couple of the pullrequests that was submitted to the original project.


Features
========
* Support for normal `56dp` and mini `40dp` buttons.

  ![Demo](screenshots/buttons.png)

* Customizable background colors for normal and pressed states and icon drawable.

  ![Demo](screenshots/custom.png)

* Convenience `AddFloatingActionButton` class with plus icon drawn in code.
* `FloatingActionsMenu` which can be expanded/collapsed to reveal multiple actions.

  ![Demo](screenshots/menu.gif)

* Optional labels for buttons in `FloatingActionsMenu`.

  ![Demo](screenshots/labels.png)

Usage
=====
Just add the dependency to your `build.gradle`:

```groovy
dependencies {
    compile 'com.github.conhea:floatingactionbutton:2.0.3'
}
```

To see how the buttons are added to your xml layouts, check the sample project.


License
=======

    Copyright (C) 2018 Thomas Bohsen Schmidt

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
