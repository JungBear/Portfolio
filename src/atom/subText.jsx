import React from 'react';

const SubText = ({children}) => {
    return (
        <div className='text-sm font-large text-gray-500'>
            {children}
        </div>
    );
};

export default SubText;