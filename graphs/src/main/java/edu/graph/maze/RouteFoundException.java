package edu.graph.maze;

/**
 * The purpose of this class is to denote that we found a successful path..,
 * This is the happy path... This is not the general usage of the exception...
 * As we are using recursive calls return wont work, so we are using exception flow to track the success path...
 * Not sure whether it is a good way or not... :(
 */
public class RouteFoundException extends RuntimeException {
}
