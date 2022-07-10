# TDXExtended
Extend the TDX Base functionality via WebAPIs


This includes a partial rebuild of the TeamDynamix provided dll library for Visual Studio (version 11.4.10.11) in Java for use with this application.

This application only contains a single processes at this time, a bulk management process that pulls a large listing of users and adds them to either a single group or multiple groups (as defined by the user).  There is also an option to remove the current groups from the listed user selection (disabled by default).

Both the Processes and Tasks are built in an extensible manner, so using the TDXProcess abstract class and the TDXTask interface class to build subsequent processes is almost a plug-and-play design.  The interactions with the TDX API are tied specifically with the Task portions for each step in an overall process.

Future ideas for processes are:
   * Create an interaction with Active Directory to match AD group members and update the TDX group membership appropriately.
   * Create an interaction with an external asset management / discovery system, like SCCM or KACE and import the data from these systems into the asset management side of TDX for a single pane view of the assets.
   
