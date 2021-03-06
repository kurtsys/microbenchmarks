package microbenchmarks.stringEntity;

import com.fasterxml.jackson.core.*;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.*;

/**
 * Created by qsys on 22/06/14.
 */
public class JsonArraySmileSerialize
      extends BenchmarkSerialize
{

   public JsonArraySmileSerialize() {
      super(JsonArraySmileSerialize.class);

   }

   private JsonArraySmileSerialize(Class benchmarkClass) {
      super(benchmarkClass);
   }

   private microbenchmarks.stringEntity.model.FactoidJsonArray factoid
         = new microbenchmarks.stringEntity.model.FactoidJsonArray(entity, attribute, value);


   @Benchmark
   public byte[] benchmarkSerialize() {
      try
      {
         return microbenchmarks.stringEntity.model.JsonMapper.smileMapper().writeValueAsBytes(factoid);
      } catch (JsonProcessingException e)
      {
         e.printStackTrace();
      }

      return new byte[]{};

   }


   public static void main(String[] args) throws RunnerException {
      BenchmarkSerialize bs = new JsonArraySmileSerialize(JsonArraySmileSerialize.class);
      bs.runBenchmark();
   }

}
