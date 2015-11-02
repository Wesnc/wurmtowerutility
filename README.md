# Wurm Tower Bash Utility
## About
This utility will tail log files output by both Wurm Online and Wurm Unlimited and check for defensive advisor tower bash messages.

## Usage
1. Usage
  1. Add the project to your IDE of choice
  2. Run the program once to output the properties file
  3. Edit the properties file with proper values
  4. Edit the twitter config with proper values
  5. Run

### Properties File Configuration
Properties config file can be found in `Users\USERNAME\WurmUtils`. This file requires certain values in order to function

`wurm.dir`
Requires topmost Wurm directory with double backspaces. Example `wurm.dir=H:\\wurm'

'wurm.character'
Requires a character name which can be found in `wurm\players'. Example `wurm.character=Joe'

### Twitter Configuration
Config file can be found in `src/twitter4j.properties'. This file requires API Consumer keys and access tokens that can be acquired by creating a developer application on [Twitter](https://dev.twitter.com/)

`oauth.consumerKey=`
Required comsumer key that can be found in your Twitter application
`oauth.consumerSecret=`
Required comsumer secret that can be found in your Twitter application
`oauth.accessToken=`
Required access token that can be found in your Twitter application
`oauth.accessTokenSecret=`
Required access token secret that can be found in your Twitter application

## License
This project is licensed under a [Creative Commons Attribution-NonCommercial 4.0 International License.] (http://creativecommons.org/licenses/by-nc/4.0/) You are allowed to resume working on this project, without the need to release your source code. Under no circumstances are you allowed to distribute this project or a derivative work in source code or binary form, as well as operate a private game server based on this project, for any form of monetary or other compensation.
