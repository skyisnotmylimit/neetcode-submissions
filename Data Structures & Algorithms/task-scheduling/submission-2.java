class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Array to store the frequency of each task (26 possible tasks 'A'-'Z')
        int[] freq = new int[26];
        
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        
        // Sort the frequency array in descending order
        Arrays.sort(freq);
        
        // Max frequency (highest count of any task)
        int maxFreq = freq[25];
        
        // Find how many tasks have this max frequency
        int maxCount = 0;
        for (int i = 25; i >= 0 && freq[i] == maxFreq; i--) {
            maxCount++;
        }
        
        // Calculate the least number of intervals
        int partCount = maxFreq - 1; // Number of gaps between the most frequent tasks
        int partLength = n - (maxCount - 1); // Length of each part (excluding filled maxFreq tasks)
        int emptySlots = partCount * partLength; // Total empty slots to be filled with other tasks
        int availableTasks = tasks.length - maxFreq * maxCount; // Remaining tasks to fill empty slots
        int idles = Math.max(0, emptySlots - availableTasks); // Calculate idle slots if any
        
        return tasks.length + idles;
    }
}
