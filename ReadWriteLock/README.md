Read Write Lock
=================================================

For this homework assignment, you will create (1) a custom read write lock and (2) a thread safe path set using that lock.

See the Javadoc comments in [`ReadWriteLock.java`](src/ReadWriteLock.java) and [`ThreadSafePathSet.java`](src/ThreadSafePathSet.java) for template code and additional details.

## Files ##

The following files are required for this project.

- [`src/ReadWriteLock.java`](src/ReadWriteLock.java)
- [`src/ReadWriteLockTest.java`](src/ReadWriteLockTest.java)
- [`src/ThreadSafePathSet.java`](src/ThreadSafePathSet.java)
- [`src/ThreadSafePathSetTest.java`](src/ThreadSafePathSetTest.java)

## Hints ##

Below are some hints that may help with this homework assignment:

- Decide whether a block of operations are read operations, write operations, or mixed (and hence need a write lock) **with respect to the shared data**.  

- The provided tests are not fool-proof. They try to recreate conditions that will cause issues if your lock or set are incorrectly implemented, but just because the tests pass does not mean your implementations are correct.

You are not required to use these hints in your solution. There may be multiple approaches to solving this homework.

**Many thanks to Sophie Engle, original author of this assignment.
