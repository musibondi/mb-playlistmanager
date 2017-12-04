MusiBondi - Playlist Manager
=

# Description

The playlist manager is the single source of truth for all playlist information.
- Handles a playlist CRUD
- Sends relevant feeds to a queue to be consumed by other services (e.g. playlistevents)
- Only service to talk with the persistence in MongoDB.

# How to start

Start application and embedded mongodb:
```
./run.sh
```

Or to remote debug on port 5005:
```
./run.sh -debug
```

# Technologies

** SpringBoot **
** MongoDB **
