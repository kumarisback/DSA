class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count task frequencies
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Step 2: Use a max-heap (negate frequencies to simulate max-heap)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int f : freq) {
            if (f > 0) {
                maxHeap.add(f);
            }
        }

        // Step 3: Simulate task scheduling
        int time = 0;
        Queue<int[]> cooldown = new LinkedList<>();

        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            time++;

            // Execute the most frequent task
            if (!maxHeap.isEmpty()) {
                int remaining = maxHeap.poll() - 1;
                if (remaining > 0) {
                    cooldown.offer(new int[]{remaining, time + n});
                }
            }

            // Check if a task's cooldown is over
            if (!cooldown.isEmpty() && cooldown.peek()[1] == time) {
                maxHeap.add(cooldown.poll()[0]);
            }
        }

        return time;

    }
}
