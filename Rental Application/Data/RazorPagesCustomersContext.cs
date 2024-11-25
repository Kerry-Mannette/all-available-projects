using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using RazorPagesRental.Models;

namespace RazorPagesRental.Data
{
    public class RazorPagesCustomersContext : DbContext
    {
        public RazorPagesCustomersContext (DbContextOptions<RazorPagesCustomersContext> options)
            : base(options)
        {
        }

        public DbSet<RazorPagesRental.Models.Customers> Customers { get; set; } = default!;
        public object Rentals { get; internal set; }
    }
}
