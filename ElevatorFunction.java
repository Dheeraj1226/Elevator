package Elevator.com.java;

import java.util.*;

	// Enum for the direction of the elevator
	enum Direction {
	    UP, DOWN, IDLE
	}

	// Class to represent a Floor
	class Floor {
	    private final int floorNumber;

	    public Floor(int floorNumber) {
	        this.floorNumber = floorNumber;
	    }

	    public int getFloorNumber() {
	        return floorNumber;
	    }
	}

	// Class to represent a Request
	class Request {
	    private final Floor floor;
	    private final Direction direction;

	    public Request(Floor floor, Direction direction) {
	        this.floor = floor;
	        this.direction = direction;
	    }

	    public Floor getFloor() {
	        return floor;
	    }

	    public Direction getDirection() {
	        return direction;
	    }
	}

	// Class to represent the Elevator
	class Elevator {
	    private Floor currentFloor;
	    private Direction direction;
	    private final List<Request> requestQueue;

	    public Elevator() {
	        currentFloor = new Floor(0); // Starting at ground floor
	        setDirection(Direction.IDLE);
	        requestQueue = new ArrayList<>();
	    }

	    public void handleRequest(Request request) {
	        requestQueue.add(request);
	        processRequests();
	    }

	    private void processRequests() {
	        while (!requestQueue.isEmpty()) {
	            Request request = requestQueue.remove(0);
	            goToFloor(request.getFloor());
	        }
	        setDirection(Direction.IDLE);
	    }

	    private void goToFloor(Floor floor) {
	        // Simulate moving the elevator
	        System.out.println("Elevator moving from floor " + currentFloor.getFloorNumber() + " to floor " + floor.getFloorNumber());
	        currentFloor = floor;
	    }

		public Direction getDirection() {
			return direction;
		}

		public void setDirection(Direction direction) {
			this.direction = direction;
		}
	}

	// Class to represent the Elevator Controller
	class ElevatorController {
	    private final Elevator elevator;

	    public ElevatorController(Elevator elevator) {
	        this.elevator = elevator;
	    }

	    public void requestElevator(Floor floor, Direction direction) {
	        Request request = new Request(floor, direction);
	        elevator.handleRequest(request);
	    }
	}


	// Main class to test the Elevator system
	public class  ElevatorFunction{
	    public static void main(String[] args) {
	        Elevator elevator = new Elevator();
	        ElevatorController controller = new ElevatorController(elevator);

	        // Test requests
	        controller.requestElevator(new Floor(3), Direction.UP);
	        controller.requestElevator(new Floor(1), Direction.UP);
	        controller.requestElevator(new Floor(6), Direction.DOWN);
	    }
	}



