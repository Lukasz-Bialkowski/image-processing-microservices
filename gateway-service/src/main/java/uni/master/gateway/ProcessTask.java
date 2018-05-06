package uni.master.gateway;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class ProcessTask {

    @Getter @Setter private Long id;
    @Getter @Setter private String host;
    @Getter @Setter private String ipAddress;
    @Getter @Setter private String imageId;
    @Getter @Setter private int nodes;
    @Getter @Setter private int iterations;
    @Getter @Setter private Date startTime;
    @Getter @Setter private Date endTime;
    @Getter @Setter private Long totalTime;

    @Override
    public String toString() {
        return "ProcessTask{" +
                "id=" + id +
                ", host='" + host + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", imageId='" + imageId + '\'' +
                ", nodes=" + nodes +
                ", iterations=" + iterations +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", totalTime=" + totalTime +
                '}';
    }
}
