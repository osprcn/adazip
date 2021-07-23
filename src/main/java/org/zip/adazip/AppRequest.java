package org.zip.adazip;

import java.util.List;
//Apprequest working as model that conatin ..
public class AppRequest {
    public Partition getPartition() {
        return partition;
    }

    public void setPartition(Partition partition) {
        this.partition = partition;
    }

    //JSON file(input,key)
    //output in this format
    private Partition partition;

    private List<String> files;

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }
}
