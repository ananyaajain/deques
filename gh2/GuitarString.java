package gh2;
import deque.LinkedListDeque;
import deque.Deque;

// Note: This file will not compile until you complete the Deque implementations
public class GuitarString {
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor
    private Deque<Double> buffer;
    private double capacity;
    private double result;
    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        buffer = new LinkedListDeque<Double>();
        double x = Math.round(SR / frequency);
        this.capacity = x;
        int i = 0;
        while (i < capacity) {
            buffer.addFirst((double) 0);
            i += 1;
        }
    }

    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        //       Make sure that your random numbers are different from each
        //       other. This does not mean that you need to check that the numbers
        //       are different from each other. It means you should repeatedly call
        //       Math.random() - 0.5 to generate new random numbers for each array index.
        for (int i = 0; i < capacity; i++) {
            buffer.removeFirst();
            buffer.addFirst(Math.random() - 0.5);
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        double de = buffer.removeFirst();
        double en = buffer.get(0);
        double avg = ((de * DECAY + en * DECAY) / 2);
        buffer.addLast(avg);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.get(0);
    }
}
