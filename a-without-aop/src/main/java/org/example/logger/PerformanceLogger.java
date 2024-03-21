package org.example.logger;

public class PerformanceLogger {

    public PerformanceLoggerInfo start(String methodName) {
        return new PerformanceLoggerInfo(methodName, System.currentTimeMillis());
    }

    public void end(PerformanceLoggerInfo info) {

        long startTime = info.getTime();
        long endTime = System.currentTimeMillis();
        System.out.println("%s method takes times:: %s milliseconds.".formatted(info.getName(), (endTime - startTime)));
    }

    public static class PerformanceLoggerInfo {

        private String name;
        private long time;

        public PerformanceLoggerInfo(String name, long time) {
            this.name = name;
            this.time = time;
        }

        public String getName() {
            return name;
        }

        public long getTime() {
            return time;
        }
    }
}
