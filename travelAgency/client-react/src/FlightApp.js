import React from "react";
import {addFlight, deleteFlight, getFlights} from "./utils/rest-calls";

class FlightApp extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            flights: [],
            deleteFunc: this.deleteFunc.bind(this),
            addFunc: this.addFunc.bind(this)
        };
        console.log("Flight App constructor");
    }

    componentDidMount(){
        console.log('inside componentDidMount')
        getFlights().then(flights => {
            this.setState({flights})
            console.log(flights)
        });
    }

    addFunc(flight) {
        console.log("inside add func " + flight);
        addFlight(flight)
            .then(result => getFlights())
            .then(flights => this.setState({flights}))
            .catch(error => console.log('error add ', error));
    }

    deleteFunc(id){
        console.log('inside deleteFunc ' + id);
        deleteFlight(id)
            .then(result => getFlights())
            .then(flights => this.setState({flights}))
            .catch(error => console.log('error delete', error));
    }

    render() {
        return(
            <div className="FlightApp">
                <h1>Flights</h1>
                <br/>
            </div>
        )
    }
}
export default FlightApp;