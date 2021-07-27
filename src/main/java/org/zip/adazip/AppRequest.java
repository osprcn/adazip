package org.zip.adazip;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonProperty("input_files")
    private List<String> inputFiles;

    public List<String> getInputFiles() {
        return inputFiles;
    }

    public void setInputFiles(List<String> inputFiles) {
        this.inputFiles = inputFiles;
    }
    @JsonProperty("output_dir")
    private String outputDir;
    public String getOutputDir(){
        return outputDir;
    }
    public void setOutputDir(String outputDir){
        this.outputDir = outputDir;
    }

}
