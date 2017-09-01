
```bash
sbt run
[info] Running com.ingestion.client.IngestionClientActor
[INFO] [09/01/2017 15:15:12.709] [run-main-0] [akka.remote.Remoting] Starting remoting
[INFO] [09/01/2017 15:15:12.845] [run-main-0] [akka.remote.Remoting] Remoting started; listening on addresses :[akka.tcp://ClientSystem@127.0.0.1:61240]
[INFO] [09/01/2017 15:15:12.847] [run-main-0] [akka.remote.Remoting] Remoting now listens on addresses: [akka.tcp://ClientSystem@127.0.0.1:61240]
[INFO] Ingestion endpoint : ActorSelection[Anchor(akka.tcp://IngestionSystem@127.0.0.1:5150/), Path(/user/ingestion)]
[INFO] got event notification from ingestion endpoint { "EventProcessed": { "date" : Fri Sep 01 15:15:13 PDT 2017 } }
```