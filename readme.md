<div >
  <uib-accordion>
    <uib-accordion-group heading="Getting the Seed" >
      <ul>
        <li>Create a project folder somewhere on your systems and clone the seed from here: <a href="https://github.com/Lars-m/semesterseedfall2016.git">https://github.com/Lars-m/semesterseedfall2016.git</a> </li>
        <li>But since you are already looking at this page, you have probably already done this ;-)</li>
      </ul>
    </uib-accordion-group>
    <uib-accordion-group is-open="status.isFirstOpen" >
      <uib-accordion-heading>
        Architecture
      </uib-accordion-heading>

      <p>This Version of the Seed provides a Java JAX RS Backend and an Angular Frontend in a single Maven Web Project</p>

      <div class="col-md-8">
        <ul>
          <li>As usual all Backend Code should be placed in the <em>Source Packages</em> Folder</li>
          <li>As usual all Client Code should be placed in the <em>Web Pages</em> Folder (in the sub-folder <b>app</b>) which holds the Angular Frontend Project</li>
        </ul>
      </div>
      <div class="col-md-4">
        <img src='app/view4/image/architecture.PNG' style="width: 100%;">
      </div>
    </uib-accordion-group>

    <uib-accordion-group >
      <uib-accordion-heading>

        Backend Architecture
      </uib-accordion-heading>
      <p>This should come as no surprise to you.</p> 
      <p>It's a basic Maven Web Project with a few Demo REST Services included  + support for Token-based Security</p>
      <p>The seed also includes a few RESTAsured test, that demonstrates how to start an embedded Tomcat Server, and how to test REST-services that requires authentication</p>
      <br/>
    </uib-accordion-group>

    <uib-accordion-group >
      <uib-accordion-heading>       
        Frontend Architecture
      </uib-accordion-heading>
      <div class ="col-md-3">
        <img style="width: 100%;" src="app/view4/image/ClientArchitecture.PNG">
      </div>
      <div class ="col-md-9">
        <p><em style="font-weight: bold">Note: The image reflects the "two project" version of the seed, which you should use when doing client-side testing. (6-8) is not relevant for this version</em></p>
        <p>The seed is built from <a href="https://github.com/angular/angular-seed">AngularJSs</a> seed and the application skeleton of the seed is therefore heavily inspired by this seed.</p>
        <p>This seed is "twisted" to make it easier to use in a school, see this <a href="https://scotch.io/tutorials/angularjs-best-practices-directory-structure">link</a> for alternative seed-structures.</p> 
        <p>All the content of the Site Root (an alias for the app-folder) is what makes up the web-application and is what will be copied to the "Web Pages" folder of the Server project whenever you perform a clean build or deploy this project.</p>
        <ol class="list">
          <li> Contains all dependencies for the web-application (Angular-files, etc.)  </li>
          <li> A folder with files for "global" filters, directives, factories and services. If you place code in one of these files you don't need do any "includes" but obviously things must still be injected to use them in your code </li>
          <li> All the Views for this application. Each folder must as a minimum include a template for the view and a routeprovider with the routing-details </li>
          <li> The app.js (your Java-main counterpart). Open the file to understand it's purpose</li>
          <li> index.html holds the top-menu and the <em>ng-view directive</em>. All external files are included here</li>
          <li>This is where you should place all Karma-unit tests for the project</li>
          <li>Configuration-files to setup all dependencies</li>
          <li>Right-click this icon to setup Karma defaults </li>
        </ol>

      </div>
    </uib-accordion-group>

    <uib-accordion-group heading="Security Features in the Seed" >
      <h3>Test Users: (logon with these credentials to test authentication)</h3>
      <p>The Backend supports whatever roles you come up with. Out of the box the front-end only handles the roles "User" and "Admin". Adding more is however simple</p>
      <ul style="font-size: large">
        <li><b style="display: inline-block;width:7em;">User</b>username = user, password = test</li>
        <li><b style="display: inline-block;width:7em;">Admin:</b>username = admin, password = test</li>
        <li><b style="display: inline-block;width:7em;">User+Admin:</b>username = user_admin, password = test</li>
      </ul>
      <h3>Using the Security Features in this seed - <em>Server:</em></h3>
      <p>Decorate your REST classes and or methods with theese annotations: <em>@PermitAll</em> <em>@DenyAll</em> <em>@RolesAllowed</em>
      <p>See the section Securing RESTful Web Services Using Annotations here: <a href="http://docs.oracle.com/cd/E24329_01/web.1211/e24983/secure.htm#RESTF256">Securing RESTful Web Services</a>
      <P>See The server package <b>rest</b> provides examples of services using both the <em>User</em> and <em>Admin</em> Roles</p>
      <p>Username, password, and roles are hardcoded in UserFacade.java and the User Class (your task is to place this info in a database)</p>

      <h3>Using the Security Features in this seed - <em>Client</em>:</h3>
      <p>Logon/logof is ready to use.</p>
      <p>A token with credentials is automatically attached to all outgoing AJAX (REST)requests (when you are logged on) </p>
      <p>In this version users can see all menu items (even if they do not have the necessary rights). This is for you to
        observe when and where security takes place (bring up F12 in chrome and monitor the network traffic)<p>
      <p>You can hide elements (menu-items) so they are only visible when logged on with the required security role. Add <code>ng-show="isUser"</code> to
        the "view2" anchor tag in index.html and <code>ng-show="isAdmin"</code> on the "view2" tag. To see this in action.</p>
      <p>Everything you do, that relates to security on the client, can be tampered with, so the trick above should be seen as
        something to make the system more user friendly. <span style="text-decoration: underline">The real security is how REST (our data) is protected on the server. </span>
      </p>
      <h4>Not sending the JWT for specific requests</h4>
      <p>In some cases (for example when doing Cross Origin Calls) we don not want to include the jwt-token with the request</p>
      <p>Use the skipAutherization property as sketched below, to prevent the Token from being include with a request</p>
      <pre>
        $http({
          url: '/hola',
          <b>skipAuthorization: true</b>
          method: 'GET'
        });</pre>
      <p>Security in this seed was inspired by these articles</p>
      <ul style="list-style: none">
        <li> <a href="https://auth0.com/blog/2014/01/07/angularjs-authentication-with-cookies-vs-token/">Cookies vs Tokens. Getting auth right with Angular.JS</a></li>
        <li><a href="http://scytl.github.io/restguide/#_security_2">Security</a></li>
      </ul>
    </uib-accordion-group>
    <uib-accordion-group heading="Adding new files">

      The single most import thing to realize about this, and all other, seeds is how "wirred up".
      <p>As an example, let's see what it will take to include a new view:</p>
      <p>Create a new folder for the view and create (as a minimum) an html-template and a JavaScript file with (as a minimum) the route-handling for the view. In this file provide a name as sketched below:</p>
      <p><code> angular.module('myApp.<b>nameForTheView</b>', ['ngRoute'])</code></p>
      <p style="font-weight: bold">Important:</p> 
      <ol>
        <li>Copy the text: 'myApp.nameForTheView' from the *.js-file into the <em>app.js-file</em> (just look into the file to see how)</li>
        <li>Important: include the file in index.html (just look into the file to see how all other js-files are included)</li>
      </ol>
      <p>Now you can use your new view from anywhere in your application using the url you provided for the route-handling</p>
    </uib-accordion-group>
    <uib-accordion-group heading="Removing Unnecessary Page/Code" >
      <p>Whenever you use a wizard or a seed as a starting point for your applications it is important to remove code not relevant for what you are doing.</p>
      <p>One thing you always will have to remove is the "Using the Seed"-view.</p>
      <ol>
        <li>Delete the <em>view4-folder</em> and all its content.</li>
        <li>Remove the "injection" 'myApp.view4' in <em>app.js </em></li>
        <li>Remove the script-include in the file <em>index.html</em> </li>
        <li>Remove the "menu-entry" in <em>index.html</em></li>
      </ol>
    </uib-accordion-group>
    <uib-accordion-group heading="Client Side Testing" >
      <p>No support for (out-of-the-box) Client Side Testing with this version of the seed </p>
    </uib-accordion-group>
    <uib-accordion-group heading="Backend Testing" >
      <p>The seed ships with the necessary maven dependencies and plugins to use <a href=" http://rest-assured.io/">REST-Assured</a> and provides a 
        utility class <code>test.utils.EmbeddedTomcat</code> to assist in setting up an embedded Tomcat for your integrations tests.</p>
      <p>See the <code>test.InitialSeedRestIntegrationTest</code> class for an integration test example. Right-click this file from within NetBeans and select <em>Test file</em> to see test results in NetBeans</p>
      <p>Open a terminal, and navigate to the root of the project, and type: <em>mvn –verify</em> to see the test results generated by the failsafe-plugin (in the <em>target/ failsafe-reports</em> folder) </p>

    </uib-accordion-group>
    <uib-accordion-group heading="Exercises" >
      <h2>Exercise</h2>
      <h3>Adding the missing REST integration Tests</h3>
      <p>Todo --> Remove some of the tests and them as an exercise here</p>
      <h3>Make a new page</h3>
      <p>Get to know the internals of this seed. Look at the "Adding new files" section.</p>
      <p>When you have done that, make a view 5, that has a page and JS just like the other 4 views.</p>
      <h3>Make a database to persist the users</h3>
      <p>This seed does not have any database attached to it. If you look at the "UserFacade.java" you can see that right now, the users are stored in a Hashmap.</p>
      <p>Your task is to:</p>
      <ul>
        <li>Make User.java an entity by introducing the proper annotations</li>
        <li>Make a database</li>
        <li>Use the wizard to make the persistence.xml (the wizard will put it the right place)</li>
        <li>Make your facade use the newly created database instead of the HashMap</li>
      </ul>
      <p>Don't care about the security right now, we will deal with that in the next point:</p>
      <h3>Make the password hashed and salted</h3>
      <p>Having plain-text passwords in your database is the worst rookie mistake you can make (But even <a href="http://arstechnica.com/tech-policy/2011/06/sony-hacked-yet-again-plaintext-passwords-posted/">Sony</a> did this and is a rookie)</p>
      <p>If you want to read a little bit more about hashing and why it is important, then <a href="https://crackstation.net/hashing-security.htm">Crackstation</a> got you covered</p>
      <p>For a better rant: <a href="http://plaintextoffenders.com/faq/devs">Plaintextoffenders</a> also has a good FAQ </p>
      <h5>Tasks</h5>
      <ul>
        <li>Download the PasswordHash java file from the <a href="https://github.com/defuse/password-hashing/blob/master/PasswordStorage.java">Crackstation website</a></li>
        <li>Put it in the security package</li>
        <li>Check that it has the right package on the top</li>
        <li>Before persisting, call PasswordHash.createHash(password);</li>
        <li>Store the String you get in return</li>
        <li>Whenever a user tries to log in, evaluate the password sent with the hashed and salted one stored in the database by issuring: </li>
        <li>PasswordHash.validatePassword(password, wholeHash)</li>
      </ul>
      <h4>Important, commit and push to your own repository and use THIS VERSION, with a database for the rest of the semester</h4>
      <h3>Add another role</h3>
      <p>Make a new role for your new page: members. Members needs to have access to both view2 and your newly created view5</p>
    </uib-accordion-group>

  </uib-accordion>
</div>
