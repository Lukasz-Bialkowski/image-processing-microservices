package uni.master.gateway;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class ResourceBenchmark {

    @Getter @Setter Long id;
    @Getter @Setter private String host;
    @Getter @Setter private String ipAddress;
    @Getter @Setter private long TotalSwapSpaceSize;
    @Getter @Setter private long TotalPhysicalMemorySize;
    @Getter @Setter private long FreePhysicalMemorySize;
    @Getter @Setter private Date Timestamp;
    @Getter @Setter private long FreeSwapSpaceSize;
    @Getter @Setter private double SystemCpuLoad;
    @Getter @Setter private double ProcessCpuLoad;
    @Getter @Setter private double SystemLoadAverage;

    @Override
    public String toString() {
        return "ResourceBenchmark{" +
                "id=" + id +
                ", host='" + host + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", TotalSwapSpaceSize=" + TotalSwapSpaceSize +
                ", TotalPhysicalMemorySize=" + TotalPhysicalMemorySize +
                ", FreePhysicalMemorySize=" + FreePhysicalMemorySize +
                ", Timestamp=" + Timestamp +
                ", FreeSwapSpaceSize=" + FreeSwapSpaceSize +
                ", SystemCpuLoad=" + SystemCpuLoad +
                ", ProcessCpuLoad=" + ProcessCpuLoad +
                ", SystemLoadAverage=" + SystemLoadAverage +
                '}';
    }
}

