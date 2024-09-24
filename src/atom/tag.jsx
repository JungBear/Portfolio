import React from 'react';

const Tag = ({children}) => {
    return (
        <span className="bg-default text-white px-2 py-0.5 rounded-xl text-xs mr-1 inline-block mt-1">
            {children}
        </span>
    );
};

export default Tag;