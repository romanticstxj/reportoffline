## 离线报表

#### Compile: 
> #####  sbt clean assembly

#### Run:
> <pre> 
> path/to/spark/bin/spark-submit \
>   --executor-memory Xg \
>   --driver-memory Xg
>   --total-executor-cores X \
>   --executor-cores X \
>   --deploy-mode cluster \
>   --master &lt;master&gt; \
>   --class com.madhouse.ssp.ReportApp \
>   hdfs://XX/path/to/&lt;application&gt;.jar \
>   hdfs://XX/path/to/&lt;application&gt;.conf
> </pre>

#### Config:
> <pre> 
> app {
>   mysql {
>     url = "@mysql.url@"
>     user = "@mysql.user@"
>     pwd = "@mysql.pwd@"
>   }
> 
>   log.path {
>     mediabid  = "@log.path.mediabid@"
>     dspbid    = "@log.path.dspbid@"
>     impression = "@log.path.impression@"
>     click      = "@log.path.click@"
>   }
> 
>   table = {
>     media {
>       base     = "@table.media.base@"
>       location = "@table.media.location@"
>     }
> 
>     dsp {
>       base     = "@table.dsp.base@"
>       location = "@table.dsp.location@"
>       media    = "@table.dsp.media@"
>     }
> 
>     policy {
>       base     = "@table.policy.base@"
>       location = "@table.policy.location@"
>     }
>   }
> 
>   insert = [@insert@]
> }
> </pre>