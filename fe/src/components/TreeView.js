import React from 'react';
import Tree from 'react-d3-tree';

/*
 * Example tree data
const myTreeData = [
    {
        name: 'Top Level',
        attributes: {
            keyA: 'val A',
            keyB: 'val B',
            keyC: 'val C',
        },
        children: [
            {
                name: 'Level 2: A',
                attributes: {
                    keyA: 'val A',
                    keyB: 'val B',
                    keyC: 'val C',
                },
            },
            {
                name: 'Level 2: B',
            },
        ],
    },
];
*/

class TreeView extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            treeData: [{
                name: "Loading"
            }]
        };
    }

    componentDidMount() {
        fetch("/tree")
            .then(response => response.json())
            .then(responseJson => {
                this.setState({
                    treeData: [responseJson]
                });
            });
    }

    render() {
        const { treeData } = this.state;
        return (
            <div id="treeWrapper" style={{width: '100%', height: '100%'}}>

                <Tree style={{width: '100%', height: '100%'}} data={treeData} pathFunc='straight' orientation='vertical' translate={{x: 100, y: 100}}/>

            </div>
        );
    }
}

export default TreeView;